<?php
if(!$_REQUEST['nombreapellido'] || !$_REQUEST['alias'] || !$_REQUEST['telefono']) {
    echo "false";
    exit;
}

$nombreapellido = $_REQUEST['nombreapellido'];
$alias = $_REQUEST['alias'];
$telefono = $_REQUEST['telefono'];

require_once 'config.php';

$conexion = new mysqli(SERVER,USER,PASSWORD,DATABASE);

if ($conexion->connect_errno) {
    printf("Fallo en la conexión %s ", $conexion->connect_errno);
    exit();
}

$sql = "INSERT INTO usuarios (nombreapellido,alias,telefono) VALUES ('$nombreapellido','$alias','$telefono')";
$resultado = $conexion->query($sql);

if($resultado) {
    $id = $conexion->insert_id;
    echo $id;
} else {
    echo "false";
}
?>
