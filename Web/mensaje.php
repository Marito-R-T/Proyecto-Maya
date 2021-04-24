

<script type="text/javascript">
$(document).ready(function(){const valores = window.location.search;
  const urlParams = new URLSearchParams(valores);
  if(urlParams.has('mensaje')){
    $('#exampleModal').modal('show'); 
  }});
  
  function cerrar(){
    $('#exampleModal').modal('hide'); 
  }
 
</script>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Mensaje</h5>
        <button  class="close" onclick=cerrar() aria-label="Close">
          <span aria-hidden="true"><i class="fas fa-times"></i></span>
        </button>
      </div>
      <div class="modal-body">
        <?php  echo isset($_GET['mensaje']) ? $_GET['mensaje'] : ''; ?>
      </div>
      <div class="modal-footer">
        <button class="btn btn-get-started" onclick=cerrar()>Cerrar</button>
      </div>
    </div>
  </div>
</div>