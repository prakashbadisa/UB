package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    private Map<Furniture, Integer> furnitureIntegerMap;
    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        furnitureIntegerMap = new HashMap<>();;
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        furnitureIntegerMap.put(type, furnitureIntegerMap.containsKey(type) ? furnitureIntegerMap.get(type)+furnitureCount: furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return new HashMap<>();
    }

    public float getTotalOrderCost() {
        return furnitureIntegerMap == null ? 0.0f: furnitureIntegerMap.entrySet().stream().map(f -> f.getKey().cost()*f.getValue()).collect(Collectors.toList()).stream().reduce(Float::sum).get();
    }

    public int getTypeCount(Furniture type) {
        return furnitureIntegerMap.containsKey(type) ? furnitureIntegerMap.get(type) : 0;
    }

    public float getTypeCost(Furniture type) {
        return furnitureIntegerMap.containsKey(type) ? furnitureIntegerMap.get(type) * type.cost() : 0.0f;
    }

    public int getTotalOrderQuantity() {
        return furnitureIntegerMap.isEmpty() ? 0 : furnitureIntegerMap.values().stream().reduce(Integer::sum).get();
    }
}
