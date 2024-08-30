package net.doremista.recipe;

import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class HardagsteelForgeRecipe implements Recipe<SimpleInventory> {

    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;

    public HardagsteelForgeRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient()) {
            return false;
        }

        for (int i = 0; i < recipeItems.size(); i++) {
            if (!recipeItems.get(i).test(inventory.getStack(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<HardagsteelForgeRecipe> {
        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<HardagsteelForgeRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public HardagsteelForgeRecipe read(Identifier id, JsonObject json) {
            var ingredientsArray = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> ingredients = DefaultedList.ofSize(ingredientsArray.size(), Ingredient.EMPTY);

            for (int i = 0; i < ingredientsArray.size(); i++) {
                ingredients.set(i, Ingredient.fromJson(ingredientsArray.get(i)));
            }

            JsonObject outputJson = JsonHelper.getObject(json, "output");
            Item item = JsonHelper.getItem(outputJson, "item");
            int count = JsonHelper.getInt(outputJson, "count", 1); // Default count is 1 if not specified
            ItemStack output = new ItemStack(item, count);

            return new HardagsteelForgeRecipe(id, output, ingredients);
        }

        @Override
        public HardagsteelForgeRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> ingredients = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < ingredients.size(); i++) {
                ingredients.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new HardagsteelForgeRecipe(id, output, ingredients);
        }


        @Override
        public void write(PacketByteBuf buf, HardagsteelForgeRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.write(buf);
            }

            buf.writeItemStack(recipe.getOutput(null));
        }
    }
}
