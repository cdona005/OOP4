package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Armour;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ArmourCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ArmourCreation construct()
    {
        return new ArmourCreation();
    }

    @Override
    public Item fromDefaults()
    {
        // Return a **Default** Armour
        return new Armour();
    }

    @Override
    public int requiredNumberOfValues()
    {
        // Replace the return value;
        return 3;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {
        Armour armour = new Armour();
        armour.setName(tokens[0]);      
        armour.setMaterial(tokens[1]);  
        armour.setDurability(Integer.parseInt(tokens[2])); 
    
        return armour;
    }

    @Override
    public Item fromExisting(final Item original)
    {
        if (!(original instanceof Armour)) {
            throw new IllegalArgumentException("Invalid item type for Armour creation");
        }
    
        Armour originalArmour = (Armour) original;
    
        // Create a new Armour object with the same attributes as the original
        Armour clone = new Armour();
        clone.setName(originalArmour.getName());
        clone.setMaterial(originalArmour.getMaterial());
        clone.setDurability(originalArmour.getDurability());
    
        return clone;
    }
    
}
