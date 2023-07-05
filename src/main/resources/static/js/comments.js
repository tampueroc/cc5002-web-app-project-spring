    
url_donacion = "/api/comentarios?id_donacion=" + id_donacion;
url_pedido = "/api/comentarios?id_pedido=" + id_pedido;
if (id_donacion != null){
    url = url_donacion;
}
else{
    url = url_pedido;
}
function populateComments(){
    $.ajax(
        {
            url: url,
            type: "GET",
            dataType: "json",
            success: function(result){
                let tableResults = document.getElementById("table-comentarios");
                $.each(result, function(index, comentario) {
                    let resultElement = document.createElement("tr");
                    let resultElementNombre = document.createElement("td");
                    let resultElementComentario = document.createElement("td");
                    let resultElementFecha = document.createElement("td");
                    let resultElementEmail = document.createElement("td");

                    resultElementNombre.innerHTML = comentario.nombre;
                    resultElementComentario.innerHTML = comentario.comentario;
                    resultElementFecha.innerHTML = comentario.fecha;
                    resultElementEmail.innerHTML = comentario.email;

                    resultElement.append(resultElementNombre);
                    resultElement.append(resultElementEmail);
                    resultElement.append(resultElementComentario);
                    resultElement.append(resultElementFecha);
                    tableResults.append(resultElement);
                });
            },
            error: function(xhr, status, error) {
                console.log("AJAX error:", error);
            }
        }
    )
}
populateComments();