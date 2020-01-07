export interface FoodItem {
    id: number;
    itemName: string;
    price: number;
    active:boolean;
    dateOfLaunch: Date;
    category: string;
    freeDelivery: boolean; 
    image: string;
}