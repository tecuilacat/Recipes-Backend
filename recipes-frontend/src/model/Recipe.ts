import { Category } from "./Category";
import { InstructionBlock } from "./InstructionBlock";

export interface Recipe {
    id: number,
    uuid: string,
    name: string,
    description: string,
    duration: number,
    categories: Category[],
    instructionBlocks: InstructionBlock[]
}