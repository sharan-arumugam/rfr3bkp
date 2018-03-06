(function() {
    'use strict';

    angular
        .module('rfr3App')
        .controller('RecieverMySuffixDialogController', RecieverMySuffixDialogController);

    RecieverMySuffixDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Reciever', 'FunctionalGroup'];

    function RecieverMySuffixDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Reciever, FunctionalGroup) {
        var vm = this;

        vm.reciever = entity;
        vm.clear = clear;
        vm.save = save;
        vm.functionalgroups = FunctionalGroup.query({
            size: 1000000
        });
        
        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });
        
        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
    			
            if (vm.reciever.id !== null) {
               Reciever.update(vm.reciever, onSaveSuccess, onSaveError);
            } else {
              Reciever.save(vm.reciever, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('rfr3App:recieverUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }
        
        var data1 = [
            {
                "id": null,
                "name": "EMEIA IS&T Mgt",
                "children": [
                    {
                        "id": null,
                        "name": "I.T. Service COR",
                        "children": [
                            {
                                "id": "18",
                                "name": "I.T. Service COR - Turlough Fitzpatrick",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "20",
                                "name": "I.T. Service COR - Paulo Fernandes Gomes",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "IS&T G. N. C. S.",
                        "children": [
                            {
                                "id": "22",
                                "name": "IS&T G. N. C. S. - Mark Tonks",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "IS&T Corp & Customer Systems - EMEIA",
                        "children": [
                            {
                                "id": "19",
                                "name": "IS&T Corp & Customer Systems -  Kellie McDonald",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "36",
                                "name": "IS&T Corp & Customer Systems - Matteo Caprari,",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "23",
                                "name": "IS&T Corp & Customer Systems - Pina Bithal",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    }
                ],
                "selected": false
            },
            {
                "id": null,
                "name": "IS&T Eng Solutions Admin",
                "children": [
                    {
                        "id": null,
                        "name": "iOS Systems",
                        "children": [
                            {
                                "id": "48",
                                "name": "iOS Systems - George Lin",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "28",
                                "name": "iOS Systems - Kathryn Hanrahan Pierce",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "27",
                                "name": "iOS Systems - Dheeraj Singh",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "42",
                                "name": "iOS Systems - Ari Nepon",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "Applied Machine Learning",
                        "children": [
                            {
                                "id": "64",
                                "name": "Applied Machine Learning - Michael Artemiw",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "41",
                                "name": "Applied Machine Learning - Vijay Mariadassou",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "Self Service Engineering- Eddie Fan",
                        "children": [
                            {
                                "id": "26",
                                "name": "Self Service Engineering - Shain Korah Scaria",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "6",
                                "name": "Self Service Engineering - Ethan DeYoung",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "IS&T Eng Solutions Admin - Jim Neeson",
                        "children": [
                            {
                                "id": "47",
                                "name": "Corp Systems Ent. Services",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "4",
                                "name": "Finance & Admin Systems",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "39",
                                "name": "Corp Systems Dev. Ops",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "Partner Solutions and Tech",
                        "children": [
                            {
                                "id": "3",
                                "name": "Partner Solutions and Tech - Anne Lairmore",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "Customer Systems",
                        "children": [
                            {
                                "id": "10",
                                "name": "Customer Systems - Amit Bansal",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "43",
                                "name": "Customer Systems - Scott Leahy",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "56",
                                "name": "Customer Systems - Sandeep Mangal",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "16",
                                "name": "Customer Systems - Andy MacFerran",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "30",
                                "name": "Customer Systems - Vivek Chopra",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    }
                ],
                "selected": false
            },
            {
                "id": null,
                "name": "IS&T Management Admin-APAC",
                "children": [
                    {
                        "id": null,
                        "name": "IS&T Corporate Systems - APAC",
                        "children": [
                            {
                                "id": "62",
                                "name": "IS&T Corporate Systems - Siew Choo Goh",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "15",
                                "name": "IS&T Corporate Systems -Deepak Modi",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    }
                ],
                "selected": false
            },
            {
                "id": null,
                "name": "Enterprise Technology Services",
                "children": [
                    {
                        "id": null,
                        "name": "Emerging Technology ETS",
                        "children": [
                            {
                                "id": "11",
                                "name": "JMET Engineering",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "7",
                                "name": "ETS Platform Engineering",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "45",
                                "name": "ETS Architecture and Tech Dev",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "Identity Mgmt Svcs",
                        "children": [
                            {
                                "id": "63",
                                "name": "IDMS - Client Management",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "61",
                                "name": "Identity Mgmt Svcs - Vin Agarwal",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "29",
                                "name": "Core SW Engineering ETS - Selva Subramaniam",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "Client Services & Tech (CST)",
                        "children": [
                            {
                                "id": "59",
                                "name": "Client Services & Tech (CST) -  Cameron Wolff",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "44",
                                "name": "Collaboration Svcs - Anju Gagneja",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "ETS / Integration Services",
                        "children": [
                            {
                                "id": "37",
                                "name": "ETS/Integration Services - Biren Sanghrajka",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "13",
                                "name": "ETS/Integration Services - Tom Tan",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "17",
                                "name": "ETS/Integration Services - John Joseph",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    }
                ],
                "selected": false
            },
            {
                "id": null,
                "name": "GNCS - Admin",
                "children": [
                    {
                        "id": null,
                        "name": "GNCS - Strategy & Software Dev",
                        "children": [
                            {
                                "id": "60",
                                "name": "Data Center Services CA - Mike Mahedy",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "GNCS - Platform Services",
                        "children": [
                            {
                                "id": "14",
                                "name": "GNCS - Platform Services - Brian Blitzer",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "35",
                                "name": "GNCS - Platform Services-Ayumi Minamikawa",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "54",
                                "name": "GNCS - Data Services",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "8",
                                "name": "GNCS - Platform Services - Christopher Manders",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    }
                ],
                "selected": false
            },
            {
                "id": null,
                "name": "IS&T Enterprise Systems",
                "children": [
                    {
                        "id": null,
                        "name": "Global Access Systems",
                        "children": [
                            {
                                "id": "1",
                                "name": "Global Access Systems - Janette Nolan",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "51",
                                "name": "Global Access Systems - JeanMarie Mariadassou",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "32",
                                "name": "Global Access Systems - Ranjit Panigrahi",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "49",
                                "name": "Global Access Systems - Joseph Kotni",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "21",
                                "name": "Global Access Systems  - Ralf Rotter",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "5",
                                "name": "Global Data Warehousing",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "IT Governance & Planning - Brandon Casey",
                        "children": [
                            {
                                "id": "46",
                                "name": "IT Governance & Planning - David Taylor",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "34",
                                "name": "Cryptographic Services",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "IS&T Enterprise Systems - Harald Reiter",
                        "children": [
                            {
                                "id": "52",
                                "name": "Sudeep Achalia - Global ABAP",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "12",
                                "name": "Global SAP Technology",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "53",
                                "name": "SAP Arch, Sec & Perf",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "50",
                                "name": "Global ABAP",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "SAP Global Systems",
                        "children": [
                            {
                                "id": "58",
                                "name": "SAP Global Systems - Manish Agarwal",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "2",
                                "name": "SAP Global Systems - Madhu Alur",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "40",
                                "name": "SAP Global Systems - Laura Neo",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "25",
                                "name": "SAP Global Systems - Rob Reilly",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    },
                    {
                        "id": null,
                        "name": "AMR IS&T",
                        "children": [
                            {
                                "id": "57",
                                "name": "AMR IS&T - Jon White",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "24",
                                "name": "AMR IS&T - Paresh Patel",
                                "children": null,
                                "selected": false
                            }
                        ],
                        "selected": false
                    }
                ],
                "selected": false
            },
            {
                "id": null,
                "name": "Retail and Online Stores",
                "children": [
                    {
                        "id": null,
                        "name": "Mobile Apps Admin",
                        "children": [
                            {
                                "id": "31",
                                "name": "Retail IS&T - David Den Boer",
                                "children": null,
                                "selected": false
                            },
                            {
                                "id": "33",
                                "name": "Mobile Apps",
                                "children": [
                                {
                                "id": "35",
                                "name": "Mobile Apps Inn",
                                "children": [],
                                "selected": false
                            }
                            ],
                                "selected": false
                            }
                        ],
                        "selected": false
                    }
                ],
                "selected": false
            }
        ];

        $scope.data = angular.copy(data1);
        $scope.datas = angular.copy(data1);

    }
})();
