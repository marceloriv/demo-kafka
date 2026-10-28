package cl.duoc.demo_kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.demo_kafka.model.Pedido;
import cl.duoc.demo_kafka.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> crear(@RequestBody Pedido pedido) {
        return ResponseEntity.accepted().body(pedidoService.publicar(pedido));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> pedidoInvalido(IllegalArgumentException error) {
        return ResponseEntity.badRequest().body(error.getMessage());
    }
}
