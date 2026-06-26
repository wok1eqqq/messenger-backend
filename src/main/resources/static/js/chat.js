const stompClient = new StompJs.Client({
    brokerURL: 'ws://26.245.198.204:8080/admin-websocket',
});

stompClient.activate();

stompClient.onConnect = (frame) => {

    console.log('Connected: ' + frame);

    // stompClient.subscribe('/topic/all', onMessageGet);

};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

function onMessageGet(message) {

    const data = JSON.parse(message.body);

    Toastify({
        text: data.message,
        duration: 5000,
        close: true,
        gravity: "top",
        position: "right",
        stopOnFocus: true,
        style: {
            background: "linear-gradient(to right, #00b09b, #96c93d)"
        }
    }).showToast();

}