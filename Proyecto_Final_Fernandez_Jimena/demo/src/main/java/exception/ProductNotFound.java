package exception;

public class ProductNotFound extends Exceptions {

    public ProductNotFound(String searchTerm) {
        super(String.format("No se encontro ningun producto. se busco usando el siguiente termino: %s", searchTerm));
    }


}
