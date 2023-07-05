let updateSearchResults = (results) => {
  let searchResults = document.getElementById("searchResults");
  let tableResults = document.getElementById("tableResults");
  let searchType = document.getElementById("searchType");

  tableResults.innerHTML = "";
  for (let result of results) {
    let resultElement = document.createElement("tr");
    let resultElementNombre = document.createElement("td");
    let resultElementTipo = document.createElement("td");
    let resultElementCantidad = document.createElement("td");
    let resultElementTotalComentarios = document.createElement("td");
    let donacion_raw = JSON.stringify(result.donacion);
    let donacion = JSON.parse(donacion_raw);
    resultElementNombre.textContent = donacion.nombre;
    resultElementTipo.textContent = donacion.tipo;
    resultElementCantidad.textContent = donacion.cantidad;
    resultElementTotalComentarios.textContent = result.total_comentarios;

    resultElement.appendChild(resultElementNombre);
    resultElement.appendChild(resultElementTipo);
    resultElement.appendChild(resultElementCantidad);
    resultElement.appendChild(resultElementTotalComentarios);
    resultElement.addEventListener("click", () => {
      if (searchType.value == 'donacion'){
        window.location.href = `/comentarios?id_donacion=${donacion.id}`;
      }
      else if (searchType.value == 'pedido') {
        window.location.href = `/comentarios?id_pedido=${donacion.id}`;
      }
    });
    tableResults.appendChild(resultElement);
  }
  searchResults.hidden = false;
};



let fetchAJAX = (url) => {
    fetch(url, {
      mode: "cors",
      credentials: "include",
    }) // 1 acceder al url
      .then((response) => {
        if (!response.ok) {
          console.log(response);
          throw new Error("Network response was not ok");
        }
        return response.json(); // 2 parseamos el response a un json
      })
      .then((ajaxResponse) => {
        updateSearchResults(ajaxResponse); // 3 le pasamos el data a populate...()
        return ajaxResponse;
      })
      .catch((error) => {
        console.error(
          "There has been a problem with your fetch operation:",
          error
        );
      });
  };
  $(document).ready(function () {
    $('#searchType').change(function () {
      var searchType = $(this).val();
      if (searchType === 'donacion') {
        $('#searchBox').attr('placeholder', 'Buscar por nombre de contacto en donaciones');
      } else if (searchType === 'pedido') {
        $('#searchBox').attr('placeholder', 'Buscar por nombre de contacto en pedidos');
      }
    });

    $('#searchBox').on('input', function () {
      var searchText = $(this).val();
      if (searchText.length >= 3) {
        if (searchType.value == 'donacion') {
          fetchAJAX(`/api/donaciones?name=${searchText}`);
        }
        else if (searchType.value == 'pedido') {
          fetchAJAX(`/api/pedidos?name=${searchText}`);
        }
        // Realizar la búsqueda dinámica y mostrar los resultados
        // Aquí puedes utilizar AJAX para hacer la solicitud al servidor y obtener los resultados
        // Luego, puedes mostrar los resultados en una lista en el DOM
      }
    });
  });