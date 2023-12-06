package structural;

import java.util.ArrayList;
import java.util.List;

interface ShipmentService {
    void executeAfterCreateShipment();
}

class ShipmentHistoryService implements ShipmentService {

    @Override
    public void executeAfterCreateShipment() {
        System.out.println("Create shipment in shipment history");
    }
}

class ShipmentDeliveryService implements ShipmentService {

    @Override
    public void executeAfterCreateShipment() {
        System.out.println("Communicate to Delivery service after create shipment");
    }
}

class CompositeShipment implements ShipmentService {
    private List<ShipmentService> shipmentServices;

    public CompositeShipment(List<ShipmentService> shipmentServices) {
        this.shipmentServices = shipmentServices;
    }

    @Override
    public void executeAfterCreateShipment() {
        for (ShipmentService shipmentService: shipmentServices) {
            shipmentService.executeAfterCreateShipment();
        }
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        List<ShipmentService> shipmentServices = new ArrayList<>();

        ShipmentService shipmentService1 = new ShipmentHistoryService();
        ShipmentService shipmentService2 = new ShipmentDeliveryService();

        shipmentServices.add(shipmentService1);
        shipmentServices.add(shipmentService2);

        CompositeShipment compositeShipment = new CompositeShipment(shipmentServices);

        compositeShipment.executeAfterCreateShipment();
    }

}
