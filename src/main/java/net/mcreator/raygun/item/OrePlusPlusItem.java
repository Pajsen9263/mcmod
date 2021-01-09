
package net.mcreator.raygun.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.block.BlockState;

import net.mcreator.raygun.RaygunModElements;

import com.google.common.collect.Multimap;

@RaygunModElements.ModElement.Tag
public class OrePlusPlusItem extends RaygunModElements.ModElement {
	@ObjectHolder("raygun:ore_plus_plus")
	public static final Item block = null;
	public OrePlusPlusItem(RaygunModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(50000).rarity(Rarity.EPIC));
			setRegistryName("ore_plus_plus");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			return new ItemStack(this);
		}

		@Override
		public int getItemEnchantability() {
			return 64;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 2;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 100F;
		}

		@Override
		public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
			Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot);
			if (slot == EquipmentSlotType.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "item_damage", (double) 98, AttributeModifier.Operation.ADDITION));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
						new AttributeModifier(ATTACK_SPEED_MODIFIER, "item_attack_speed", -2.4, AttributeModifier.Operation.ADDITION));
			}
			return multimap;
		}

		@Override
		public boolean canHarvestBlock(BlockState state) {
			return true;
		}
	}
}
