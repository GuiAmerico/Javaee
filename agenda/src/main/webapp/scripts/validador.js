const validar = () => {
	const nome = frmContato.nome.value;
	const fone = frmContato.fone.value;
	if(nome === ""){
		alert("PREENCHA O CAMPO NOME!");
		frmContato.nome.focus();
		return false;
	}else if(fone === ""){
		alert("PREENCHA O CAMPO FONE!");
		frmContato.fone.focus();
		return false;
	}else{
		return document.forms["frmContato"].submit();
	}
}