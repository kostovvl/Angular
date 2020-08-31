class KeyValuePair<K, V> {
    public key: K;
    public value: V;

    constructor() {

    }

    public setKeyValue(key: K, value: V): void {
        this.key = key;
        this.value = value;
    } 

    public display(): void {
        console.log(`Key = ${this.key}, Value = ${this.value}`);
    }
}

let kvp = new KeyValuePair<number, string>();
kvp.setKeyValue(1, "Steve");
kvp.display();
