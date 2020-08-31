class Ticket{
    constructor(public destination: string,
        public price: number, 
        public status: string) {
    }
}

function sortTickets(tickets, cryterim) {

    const ticketsArr = new Array<Ticket>();

    tickets.forEach(ticket => {
        let tokens = ticket.split('|');
        const current = new Ticket(tokens[0], tokens[1], tokens[2]);
        ticketsArr.push(current);
    });

    ticketsArr.sort((a, b) => {
        let result = 0;
        switch (cryterim) {
            case 'destination': result = a.destination.localeCompare(b.destination); break;
            case 'price': result = a.price - b.price;
            case 'status': result = a.status.localeCompare(b.status);
        }
        return result;
    })

    console.log(JSON.stringify(ticketsArr));
}

sortTickets(['Philadelphia|94.20|available',
'New York City|95.99|available',
'New York City|95.99|sold',
'Boston|126.20|departed'],
'destination'
);