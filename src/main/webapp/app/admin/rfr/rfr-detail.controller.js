(function() {
    'use strict';

    angular
        .module('rfr3App')
        .controller('RfrDetailController', RfrDetailController);

    RfrDetailController.$inject = ['$stateParams', 'Rfr'];

    function RfrDetailController($stateParams, Rfr) {
        var vm = this;

        vm.load = load;
        vm.rfr = {};

        vm.load($stateParams.requestId);

        function load(requestId) {
            Rfr.get({requestId: requestId}, function(result) {
                vm.rfr = result;
            });
        }
    }
})();
