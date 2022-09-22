const confirmar = (idcon) => {
	let resposta = confirm("Confirma a exclusão deste contato?");
	if(resposta === true) {
		location.href = "delete?idcon=" + idcon;
	}
}