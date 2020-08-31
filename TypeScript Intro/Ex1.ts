class MyData{
    public method: string;
    public url: string;
    public version: string;
    public message: string;
    public response: string;
    public fulfiled: boolean;

    constructor(method: string, url: string, version: string, message: string) {
        this.method = method;
        this.message = message;
        this.version = version;
        this.response = '';
        this.fulfiled = false;
    }
}

let result = new MyData('GET', 'http://google.com', 'HTTP/1.1', '')

console.log(result);