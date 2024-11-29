package hn.unah.proyecto.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.proyecto.dtos.ClienteDTO;
import hn.unah.proyecto.servicios.ClienteServicio;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "API de Clientes", version = "1.0", description = "API Prestamos" ))

@RestController
@RequestMapping("api/clientes")

public class ClienteControlador {

      @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/obtener/dni")
    @Operation(summary= "Obtiene cliente", description="retorna algo")
    public Optional<ClienteDTO> obtenerPorId(@RequestParam(name="dni")  @Parameter(description = "Id del cliente") String dni) {
       
        return this.clienteServicio.obtenerPorDni(dni);
    }

    @GetMapping("/obtener")
    @Operation(summary= "Obtiene cliente", description="retorna algo")
    public List<ClienteDTO> obtenerTodos() {
        return this.clienteServicio.obtenerTodos();
    }

    @PostMapping("/crear/nuevo")
    public String crearNuevoCliente(@RequestBody ClienteDTO nvoCliente) {
        return this.clienteServicio.crearCliente(nvoCliente);
    }

    @DeleteMapping("/eliminar/{dni}")
    public String eliminarCliente(@PathVariable(name="dni") String dni){
        return this.clienteServicio.eliminarClientePorId(dni);
    }
    
}
