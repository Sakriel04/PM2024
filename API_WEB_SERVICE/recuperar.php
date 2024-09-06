<?php
if(!$_REQUEST['idusuario']) {
    echo "false";
    exit;
}

require_once 'config.php';

$conexion = new mysqli(SERVER,USER,PASSWORD,DATABASE);

if ($conexion->connect_errno) {
    printf("Fallo en la conexión %s ", $conexion->connect_errno);
    exit();
}

$idusuario = $_REQUEST['idusuario'];
$result = array();
$result['data'] = array();
$result['success'] = "false";

$sql = "select * from usuarios where idusuario=$idusuario";
$resultset = $conexion->query($sql);
$row_cnt = mysqli_num_rows($resultset);

if ($row_cnt>0) {
    $result['success'] = "true";

    while ($fila = $resultset->fetch_array()) {

        $index['idusuario'] = $fila['0'];
        $index['nombreapellido'] = $fila['1'];
        $index['alias'] = $fila['2'];
        $index['telefono'] = $fila['3'];

        array_push($result['data'],$index);
    }
}

echo json_encode($result);
?>
