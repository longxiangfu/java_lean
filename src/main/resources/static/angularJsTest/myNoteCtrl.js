app.controller('myNoteCtrl', function ($scope) {
    $scope.message = "";
    $scope.save = function () {
        alert("nore saved");
    };
    $scope.clear = function () {
        $scope.message = "";
    };
    $scope.left = function () {
        return 100 - $scope.message.length;
    }
});