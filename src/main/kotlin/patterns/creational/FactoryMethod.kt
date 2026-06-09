//package patterns.creational
//
//interface ProductoPendienteFactoryMethod {
//    fun descripcion(): String
//}
//
//abstract class TallerPendiente {
//    fun prepararPedido(): String {
//        val producto = crearProductoPendiente()
//        return "Pedido preparado para ${producto.descripcion()}"
//    }
//
//    protected open fun crearProductoPendiente(): ProductoPendienteFactoryMethod {
//        // TODO: reemplaza este método por un verdadero método fábrica abstracto.
//        return object : ProductoPendienteFactoryMethod {
//            override fun descripcion(): String = "producto temporal"
//        }
//    }
//}
//
//class FactoryMethodDemo {
//    fun ejecutar(): String {
//        // TODO: crea un creador concreto y úsalo desde aquí.
//        return TallerLocal().prepararPedido()
//    }
//}
//
//class TallerLocal : TallerPendiente()

interface Producto {
    fun descripcion(): String
}

class ProductoDigital : Producto {
    override fun descripcion(): String = "Producto digital (descarga inmediata)"
}

abstract class Taller {

    fun prepararPedido(): String {
        val producto = crearProducto()
        return "Pedido preparado para: ${producto.descripcion()}"
    }

    protected abstract fun crearProducto(): Producto
}

class TallerLocal : Taller() {
    override fun crearProducto(): Producto = ProductoDigital()
}

class FactoryMethodDemo {
    fun ejecutar(): String {
        val taller: Taller = TallerLocal()
        return taller.prepararPedido()
    }
}