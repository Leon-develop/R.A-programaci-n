$(document).ready(function() {
    var table = $('#ventaTable').DataTable({
        "sAjaxSource": "/api/venta",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "detalleventa" },
            { "mData": "fecha" },           
            
        ]
    })
});