import "./RecipeCard.css"

import { Recipe } from "../model/Recipe"
import { useNavigate } from "react-router-dom"

export interface RecipeCardProps {
    recipe: Recipe
}

export const RecipeCard = (props: RecipeCardProps) => {

    const navigate = useNavigate();

    const redirectToRecipe = () => {
        navigate('/recipe/' + props.recipe.uuid);
    }

    return <div className="recipe-card"
                onClick={() => redirectToRecipe()}
                title={props.recipe.name}>
        <h2>{props.recipe.name}</h2>
        <pre>{props.recipe.description}</pre>
        <img src="https://img.chefkoch-cdn.de/rezepte/393031127655461/bilder/1585337/crop-960x540/spaghetti-bolognese.jpg" />
    </div>

}