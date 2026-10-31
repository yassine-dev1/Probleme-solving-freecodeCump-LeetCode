class SolutionIterative {

     private digits : string ;
     private length : number ;
     private phoneNumber : Record<string,string> = {
        "2": "abc",
        "3": "def",
        "4": "ghi",
        "5": "jkl",
        "6": "mno",
        "7": "pqrs",
        "8": "tuv",
        "9": "wxyz"
    };

     // constructor
    constructor( digits: string){
       this.digits = digits;
       this.length = digits.length;
    }

    combinaisonPhone() : string[] {

        if (!this.digits || this.length === 0) {
          return [];
        }

        let result : string[] = [""];
    
         for(let idx=0; idx<this.length; idx++ )
         {
            let tempQueue :  string[] = [];
            const currentDigit = this.digits[idx];
            const letters = this.phoneNumber[currentDigit];

            for(const prefix of result) {
                for(let idx2=0; idx2<letters.length; idx2++)
                {
                    tempQueue.push(prefix+letters[idx2]);
                }
            }
            result = tempQueue;
         }
    
         return result;

    }

}

let sol = new SolutionIterative("239");
console.log(sol.combinaisonPhone());


