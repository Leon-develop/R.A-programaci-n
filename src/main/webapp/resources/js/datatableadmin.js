$(document).ready(function() {
    var table = $('#adminTable').DataTable({
        "sAjaxSource": "/api/admin",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "nombre" },
            { "mData": "apellidos" },
            { "mData": "direccion" },
            { "mData": "correo" },
            { "mData": "telefono" },
            
        ]
    })
});