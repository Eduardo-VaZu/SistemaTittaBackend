package com.sistemaBackend.SistemaTittaBackend.mapper;

import com.sistemaBackend.SistemaTittaBackend.dto.response.*;
import com.sistemaBackend.SistemaTittaBackend.model.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Mapper {

    public SedeResponseDTO toSedeResponseDTO(Sede sede) {
        if (sede == null) {
            return null;
        }

        SedeResponseDTO dto = new SedeResponseDTO();
        dto.setIdSede(sede.getIdSede());
        dto.setNombreSede(sede.getNombreSede());
        dto.setTelefono(sede.getTelefono());
        dto.setEstado(sede.getEstado());
        dto.setDireccion(toDireccionResponseDTO(sede.getDireccion()));
        dto.setHorariosOperacion(sede.getHorariosOperacion().stream()
                .map(this::toHorarioResponseDTO)
                .collect(Collectors.toList()));

        return dto;
    }

    private DireccionResponseDTO toDireccionResponseDTO(Direccion direccion) {
        if (direccion == null) {
            return null;
        }
        DireccionResponseDTO dto = new DireccionResponseDTO();
        dto.setIdDireccion(direccion.getIdDireccion());
        dto.setCalle(direccion.getCalle());
        dto.setNumeroExterior(direccion.getNumeroExterior());
        dto.setCodigoPostal(direccion.getCodigoPostal());
        dto.setCiudad(direccion.getCiudad());
        dto.setEstadoProvincial(direccion.getEstadoProvincial());
        return dto;
    }

    private HorarioOperacionSedeResponseDTO toHorarioResponseDTO(HorarioOperacionSede horario) {
        if (horario == null) {
            return null;
        }
        HorarioOperacionSedeResponseDTO dto = new HorarioOperacionSedeResponseDTO();
        dto.setIdHorarioOperacionSede(horario.getIdHorarioOperacionSede());
        dto.setDiaSemana(horario.getDiaSemana());
        dto.setHoraApertura(horario.getHoraApertura());
        dto.setHoraCierre(horario.getHoraCierre());
        return dto;
    }

    public ProductoResponseDTO toProductoResponseDTO(Producto producto) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setIdProducto(producto.getIdProducto());
        dto.setNombreProducto(producto.getNombreProducto());
        dto.setSku(producto.getSku());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setEstadoProducto(producto.isEstadoProducto());
        if (producto.getCategoria() != null) {
            dto.setIdCategoria(producto.getCategoria().getIdCategoria());
        }
        if (producto.getImagen() != null) {
            dto.setImagen(toImagenResponseDTO(producto.getImagen()));
        }
        dto.setStocks(producto.getStocks().stream()
                .map(this::toStockSedeResponseDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    private ImagenProductoResponseDTO toImagenResponseDTO(ImagenProducto imagen) {
        ImagenProductoResponseDTO dto = new ImagenProductoResponseDTO();
        dto.setIdImagen(imagen.getIdImagen());
        dto.setImagenUrl(imagen.getImagenUrl());
        return dto;
    }

    private StockSedeResponseDTO toStockSedeResponseDTO(StockSede stock) {
        StockSedeResponseDTO dto = new StockSedeResponseDTO();
        dto.setIdProducto(stock.getProducto().getIdProducto());
        dto.setIdSede(stock.getSede().getIdSede());
        dto.setCantidad(stock.getCantidad());
        return dto;
    }
}