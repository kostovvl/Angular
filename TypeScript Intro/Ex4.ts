abstract class Melon{
    public weight: number;
    public melonSort: string;

    constructor(weight: number, melonSort: string) {
        this.weight = weight;
        this.melonSort = melonSort;
    }
}

export class WaterMelon extends Melon{
    public elementIndex: number;
    constructor(weight: number, melonSort: string) {
        super(weight, melonSort);
        this.elementIndex = this.weight * melonSort.length;
    }

    public toString(): string {
        return `Element: ${WaterMelon.name.substring(0, WaterMelon.name.length - 5)}
Sort: ${this.melonSort}
Element Index: ${this.elementIndex}`
    }
}

let watermelon : WaterMelon = new WaterMelon(12.5, "Kingsize");
console.log(watermelon.toString());
