# AuctionManager

Proyecto Final Diseño De Sistemas

## Cristopher Becerra (203991)

Caso de Uso 4: Manejo de Subastas.

- El Administrador de Subastas utiliza el patron `Singleton` para tener siempre a la misma instancia del `AuctionManager` ya que este no cambiara entre `Sesiones`.
- Los `Clientes` tiene un registro de operaciones individual, donde se registra cuando se crearon, se suscribieron a un `Producto` o realizaron una `Puja`. El archivo se guarda en la ruta `registro_auctions/clients/`.
