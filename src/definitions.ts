export interface DocumentReaderPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
