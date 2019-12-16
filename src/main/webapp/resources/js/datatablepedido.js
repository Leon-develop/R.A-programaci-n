$(document).ready(function() {
    var table = $('#pedidoTable').DataTable({
        "sAjaxSource": "/api/pedido",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "concepto" },
            { "mData": "cantidad" },
            { "mData": "precio" },            
            
        ]
    })
});