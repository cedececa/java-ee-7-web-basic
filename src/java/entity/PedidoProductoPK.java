/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cheng
 */
@Embeddable
public class PedidoProductoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PEDIDO_ID")
    private int pedidoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTO_ID")
    private int productoId;

    public PedidoProductoPK() {
    }

    public PedidoProductoPK(int pedidoId, int productoId) {
        this.pedidoId = pedidoId;
        this.productoId = productoId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pedidoId;
        hash += (int) productoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoProductoPK)) {
            return false;
        }
        PedidoProductoPK other = (PedidoProductoPK) object;
        if (this.pedidoId != other.pedidoId) {
            return false;
        }
        if (this.productoId != other.productoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PedidoProductoPK[ pedidoId=" + pedidoId + ", productoId=" + productoId + " ]";
    }
    
}
