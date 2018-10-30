var stompClient = null;

function connect() {
    var socket = new SockJS("/web-socket");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("Connected");
        var localGuid = document.getElementById("uuid").value;
        stompClient.subscribe("/topic/image/" + localGuid + "/reply", function () {
            window.location = "/users";
            disconnect();
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    console.log("Disconnected")
}

function guid() {
    function s4() {
        return Math.floor((1 + Math.random()) * 0x10000)
            .toString(16)
            .substring(1);
    }

    return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
}

function setGuid() {
    try {
        var hiddenInput = document.getElementById("uuid");
        hiddenInput.value = guid();
    } catch (e) {
    }
}

function send() {
    var guid = document.getElementById("uuid").value;
    stompClient.send("/app/image/" + guid, {}, document.getElementById("name").value)
}

(function () {
    setGuid();
    var form = document.getElementById("sign-up-form");
    form.onsubmit = function (e) {
        e.preventDefault();
    };
    connect();
    var submitButton = document.getElementById("submit-button");
    submitButton.onclick = function () {
        send();
        console.log("Searching image for you...")
    }
})();