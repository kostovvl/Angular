abstract class Employee{
    public name: string;
        public age: number;
        public salary: number;
        public tasks;
    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
        this.salary = 0;
        this.tasks = new Array<String>();
        }

        public work(): void {
            this.tasks.forEach(task => {
                console.log(task);
            })
        }

        public collectSalary() : void {
            console.log(`${this.name} recieved ${this.salary} this month!`)
        }
}

export class Junior extends Employee{
    constructor(name: string, age: number) {
        super(name, age)
        this.tasks.push(`${this.name} is scratching his balls!`)
    }
}

export class Senior extends Employee{
    constructor(name: string, age: number) {
        super(name, age)
        this.tasks.push(`${this.name} is scratching his balls!`)
        this.tasks.push(`${this.name} is heavily scratching his balls!`)
        this.tasks.push(`${this.name} is extremely heavily scratching his balls!`)
    }
}


export class Manager extends Employee{
    divident: number;
    constructor(name: string, age: number, divident:number) {
        super(name, age)
        this.divident = divident;
        this.tasks.push(`${this.name} is scratching his balls!`)
        this.tasks.push(`${this.name} is heavily scratching his balls!`)
        this.tasks.push(`${this.name} is extremely heavily scratching his balls!`)
        this.tasks.push(`${this.name} is breaking the balls of everybody!!!!`)
    }

    public collectSalary(): void {
        console.log(`${this.name} recieved ${this.salary + this.divident} money this month!`)
    }
}
