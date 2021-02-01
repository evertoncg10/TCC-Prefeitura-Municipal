import { Endereco } from "./Endereco";
import { Imovel } from "./Imovel";

export class Pessoa {
    public id: number;

	public telefone: string;

	public endereco: Endereco;

	public email: string;

	public imoveis: Imovel[] = [];
}