class Box<T> {
    public collection;
    constructor() {
        this.collection = new Array<T>();
    }

    public add(T): void {
        this.collection.push(T);
        }

        public remove(): void {
            this.collection.pop();
        }

        public count(): number {
            return this.collection.length; 
        }
}

let box = new Box<number>();
box.add(1);
box.add(2);
box.add(3);
console.log(box.count);
