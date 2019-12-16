$(document).ready(function() {
    var table = $('#proveedorTable').DataTable({
        "sAjaxSource": "/api/proveedor",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "nombre" },
            { "mData": "apellidos" },
            { "mData": "correo" },
            { "mData": "telefono" },
            
        ]
    })
});