import { BaseEntity } from './../../shared';

export class RNS_EMP_MASTER implements BaseEntity {
    constructor(
        public id?: number,
        public eMPCODE?: string,
        public eMPNAME?: string,
    ) {
    }
}
