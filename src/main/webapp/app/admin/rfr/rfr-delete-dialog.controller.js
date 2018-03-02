(function() {
    'use strict';

    angular
        .module('rfr3App')
        .controller('RfrDeleteController', RfrDeleteController);

    RfrDeleteController.$inject = ['$uibModalInstance', 'entity', 'User'];

    function RfrDeleteController ($uibModalInstance, entity, User) {
        var vm = this;

        vm.user = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (login) {
            User.delete({login: login},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
