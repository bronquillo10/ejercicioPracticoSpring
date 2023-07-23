import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente crearCliente(Cliente cliente) {
        // Realiza las validaciones necesarias antes de guardar el cliente
        // Por ejemplo, verificar si ya existe un cliente con el mismo número de identificación
        if (clienteRepository.existsByNumeroIdentificacion(cliente.getNumeroIdentificacion())) {
            throw new IllegalArgumentException("Ya existe un cliente con el mismo número de identificación.");
        }

        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente actualizarCliente(Cliente cliente) {
        // Realiza las validaciones necesarias antes de actualizar el cliente
        // Por ejemplo, verificar si ya existe otro cliente con el mismo número de identificación
        Cliente clienteExistente = clienteRepository.findByNumeroIdentificacion(cliente.getNumeroIdentificacion());
        if (clienteExistente != null && !clienteExistente.getId().equals(cliente.getId())) {
            throw new IllegalArgumentException("Ya existe otro cliente con el mismo número de identificación.");
        }

        return clienteRepository.save(cliente);
    }
}
