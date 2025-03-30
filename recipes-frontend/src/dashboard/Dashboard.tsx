import { useEffect, useState } from "react"
import { fetchRecipes } from "../databaseconnection/RecipeService";
import { Recipe } from "../model/Recipe";
import { RecipeCard } from "./RecipeCard";

export const Dashboard = () => {

    const [recipes, setRecipes] = useState<Recipe[]>([]);

    useEffect(() => {
        fetchRecipes("", []).then(recipes => {
            setRecipes(recipes);
        })
    }, []);

    return <div className="dashboard-container container">

        <div className="recipe-list">
            {recipes.map(recipe => (
                <RecipeCard key={recipe.uuid} recipe={recipe} />
            ))}
        </div>
        <div className="recipe-list">
            {recipes.map(recipe => (
                <RecipeCard key={recipe.uuid} recipe={recipe} />
            ))}
        </div>

    </div>

}