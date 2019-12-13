$(document).ready(function() {
    var table = $('#clienteTable').DataTable({
        "sAjaxSource": "/api/cliente",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "nombre" },
            { "mData": "apellidos" },
            { "mData": "sexo" },
            { "mData": "edad" },
            { "mData": "email" },
            { "mData": "telefono" },
        ]
    })
});