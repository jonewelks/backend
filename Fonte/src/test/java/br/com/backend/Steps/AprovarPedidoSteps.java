package br.com.backend.Steps;


import br.com.backend.Requests.AprovarPedido;
import io.cucumber.java.en.When;


public class AprovarPedidoSteps {
    AprovarPedido aprovarPedido = new AprovarPedido();

    @When("Aprova Pedido")
    public void aprovarPedido() {
        aprovarPedido.aprovarPedidoOms();
    }
    @When("Aprova Pedido Impressao Nota")
    public void aprovarPedidoNotaPendente() {
    }

}
