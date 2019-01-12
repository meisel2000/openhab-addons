/**
 * Copyright (c) 2010-2019 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.neeo.internal.models;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

/**
 * The implementation of {@link JsonDeserializer} to deserialize a {@link NeeoRecipes} class
 *
 * @author Tim Roberts - Initial contribution
 */
@NonNullByDefault
public class NeeoRecipesDeserializer implements JsonDeserializer<@Nullable NeeoRecipes> {
    @Nullable
    @Override
    public NeeoRecipes deserialize(@Nullable JsonElement jsonElement, @Nullable Type type,
            @Nullable JsonDeserializationContext context) throws JsonParseException {
        Objects.requireNonNull(jsonElement, "jsonElement cannot be null");
        Objects.requireNonNull(context, "context cannot be null");

        if (jsonElement instanceof JsonObject) {
            final List<NeeoRecipe> recipes = new ArrayList<>();
            for (Map.Entry<String, JsonElement> entry : ((JsonObject) jsonElement).entrySet()) {
                final NeeoRecipe recipe = context.deserialize(entry.getValue(), NeeoRecipe.class);
                recipes.add(recipe);
            }

            return new NeeoRecipes(recipes.toArray(new NeeoRecipe[0]));
        }
        return null;
    }

}
