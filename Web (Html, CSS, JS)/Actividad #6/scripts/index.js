//formulario de contacto
var data = [];

function sendData(){
  const name = document.querySelector("#name").value;
  const lastname = document.querySelector("#lastname").value;
  const id = document.querySelector("#id").value;
  const number = document.querySelector("#number").value;
  const email = document.querySelector("#mail").value;
  const message = document.querySelector("#message").value;

  if(name == "" || lastname == "" || id == "" || number == "" || email == "" || message == ""){
    alert("Por favor llene todos los campos");
    return false;
  }

  data.push({
      name: name,
      lastname: lastname,
      id: id,
      number: number,
      email: email,
      message: message
  });

  console.log(data);
}