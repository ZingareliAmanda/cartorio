let URI = window.location.protocol + "//" + window.location.host;

function getUrlParameter(sParam) {
	var sPageURL = window.location.search.substring(1), sURLVariables = sPageURL
			.split('&'), sParameterName, i;

	for (i = 0; i < sURLVariables.length; i++) {
		sParameterName = sURLVariables[i].split('=');

		if (sParameterName[0] === sParam) {
			return sParameterName[1] === undefined
					? true
					: decodeURIComponent(sParameterName[1]);
		}
	}
};

$(document).ready(function() {
	debugger
	$("#id").val(getUrlParameter("id"))
	$("#nome").val(getUrlParameter("nome"))
	$("#title-content").text("Editar Cartório")
})

function salvar() {
	let type;

	if (getUrlParameter("id") != "" && getUrlParameter("id") != null)
		type = "PUT";
	else
		type = "POST";

	$.ajax({
		type : type,
		url : URI + "/salvar",
		data : {
			nome : $("#nome").val(),
			id : $("#id").val()
		},
		statusCode : {
			500 : function(response) {
				alert(response)
			},
			200 : function(response) {
				alert(response)
				window.location = URI + "/cartorios"
			},
			201 : function(response) {
				alert(response)
				window.location = URI + "/cartorios"
			}
		}
	})
}

function apagar(td) {
	let id = ($(td).parent().find(".id").prop("innerHTML"))
	$.ajax({
		type : "DELETE",
		url : URI + "/deletar",
		data : {
			id : id
		},
		statusCode : {
			500 : function(response) {
				alert(response)
			},
			200 : function(response) {
				alert(response)
				location.reload();
			}
		}
	})
}

function editar(td) {
	let id = ($(td).parent().find(".id").prop("innerHTML"))
	let nome = ($(td).parent().find(".nome").prop("innerHTML"))
	window.location = URI + "/novo?id=" + id + "&nome=" + nome
	$("#title-content").innerHTML = "Editar Cartório"
}