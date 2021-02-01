import { Pessoa } from "./Pessoa";

export class PessoaFisica extends Pessoa {
    public cpf: string;

	public nome: string;

	public dataNascimento: Date;

	public sexo: string;

	public matricula: number;

	public cargo: string;

	public tipo: string;
}