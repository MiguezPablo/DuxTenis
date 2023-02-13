/* Todos los productos del rubro "librería", creados hoy. */
select nombre, fecha_creacion, rubro from (producto
left join rubro on producto.id_rubro = rubro.id_rubro)
where rubro = 'Libreria' AND fecha_creacion = CURDATE();

tambien puede ser fecha_creacion = CURRENT_DATE;

/* Monto total vendido por cliente (mostrar nombre del cliente y monto). */
select nombre, sum(precio_unitario*cantidad) as monto_total
from (venta
left join cliente
on cliente.id_cliente = venta.id_cliente)
group by venta.id_cliente
order by venta.id_cliente;

/*Cantidad de ventas por producto*/
select nombre, sum(cantidad) from (venta
left join producto
on venta.codigo_producto = producto.codigo)
group by codigo_producto
order by sum(cantidad) desc;

/* Cantidad de productos comprados por cliente en el mes actual. */
select cliente.nombre, fecha, sum(cantidad) as cant
from (venta
left join cliente
on venta.id_cliente = cliente.id_cliente)
WHERE YEAR(venta.fecha) = YEAR(CURDATE()) AND MONTH(venta.fecha) = MONTH(CURDATE())
group by nombre
order by cant desc;

/* Ventas que tienen al menos un producto del rubro "bazar". */
select nombre, cantidad, rubro from ((venta
left join producto on codigo_producto = codigo)
left join rubro on producto.id_rubro = rubro.id_rubro)
where rubro = 'bazar' and cantidad > 0;

/* Rubros que no tienen ventas en los últimos 2 meses. */
select id_rubro as id, rubro from rubro
where not exists
	(select producto.id_rubro as id from (venta
	left join producto on codigo_producto = producto.codigo)
	WHERE venta.fecha >= DATE_SUB(CURDATE(), INTERVAL 2 MONTH)
	group by id);
