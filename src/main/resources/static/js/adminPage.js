const adminBtn = document.getElementById("adminBtn");

const stompClient = new StompJs.Client({
    brokerURL: 'ws://26.245.198.204:8080/admin-websocket',
});
stompClient.activate();
stompClient.onConnect = (frame) => {


    console.log('Connected: ' + frame);
    

    // stompClient.subscribe('/topic/greetings', onMessageGet);

    adminBtn.disabled = false;

};
stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

adminBtn.onclick = () => {
    const messageInput = document.getElementsByClassName("message-input")[0]

    stompClient.publish({
        destination:"/app/all",
        body: JSON.stringify({"message": messageInput.value})
    })

    messageInput.value = ""
}