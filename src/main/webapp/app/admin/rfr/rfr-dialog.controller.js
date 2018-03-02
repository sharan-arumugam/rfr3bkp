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
            $uibModalInstance.close(result);
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        function save () {
            vm.isSaving = true;
            if (vm.rfr.requestId !== null) {
                Rfr.update(vm.rfr, onSaveSuccess, onSaveError);
            } else {
                vm.rfr.langKey = 'en';
                Rfr.save(vm.rfr, onSaveSuccess, onSaveError);
            }
        }
    }
})();
