(function() {
    'use strict';

    angular
        .module('rfr3App')
        .controller('RfrDialogController',RfrDialogController);

    RfrDialogController.$inject = ['$stateParams', '$uibModalInstance', 'entity', 'Rfr'];

    function RfrDialogController ($stateParams, $uibModalInstance, entity, Rfr) {
        var vm = this;

        vm.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
        vm.clear = clear;
        vm.languages = null;
        vm.save = save;
        vm.rfr = entity;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function onSaveSuccess (result) {
            vm.isSaving = false;
            console.log("result: "+result);
            $uibModalInstance.close(result);
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        function save () {
            vm.isSaving = true;
            console.log("saveing:: "+vm.rfr);
            Rfr.update(vm.rfr, onSaveSuccess, onSaveError);
        }
    }
})();
