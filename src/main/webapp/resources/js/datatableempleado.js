$(document).ready(function() {
    var table = $('#empleadoTable').DataTable({
        "sAjaxSource": "/api/empleado",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "nombre" },
            { "mData": "apellidos" },
            { "mData": "cargo" },           
            { "mData": "telefono" },
            
        ]
    })
});